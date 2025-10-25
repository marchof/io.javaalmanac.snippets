package io.javaalmanac.snippets.net;

import static java.net.StandardProtocolFamily.UNIX;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;

/**
 * Since Java 16 finally Unix domain local interprocess communication is
 * supported.
 * 
 * @title Unix Domain Sockets
 * @category api.util
 * @since 16
 */
public class UnixDomainSockets {

	void main() throws IOException {

		// Create a server socket on a temporary file name
		var server = ServerSocketChannel.open(UNIX);
		server.bind(null);
		var address = (UnixDomainSocketAddress) server.getLocalAddress();
		System.out.println("Listening on " + address);

		// Connect client and send a message
		try (var client = SocketChannel.open(UNIX)) {
			client.connect(address);
			client.write(ByteBuffer.wrap("Hello Socket!".getBytes(UTF_8)));
		}

		// Accept connection and read the message from it
		try (var input = Channels.newInputStream(server.accept())) {
			input.transferTo(System.out);
		}

		// Cleanup
		server.close();
		Files.delete(address.getPath());

	}

}
