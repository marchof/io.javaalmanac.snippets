package io.javaalmanac.snippets.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Since Java 16 finally Unix domain local interprocess communication is
 * supported.
 * 
 * @title Unix Domain Sockets
 * @category api.util
 * @since 16
 */
public class UnixDomainSockets {

	public static void main(String... args) throws IOException {

		// Allocate a file name
		Path socketfile = Files.createTempFile("UnixDomainSockets", ".socket");
		Files.delete(socketfile);

		// Create a server server socket
		ServerSocketChannel server = ServerSocketChannel.open(StandardProtocolFamily.UNIX);
		server.bind(UnixDomainSocketAddress.of(socketfile));

		// Connect client and send a message
		SocketChannel client = SocketChannel.open(StandardProtocolFamily.UNIX);
		client.connect(UnixDomainSocketAddress.of(socketfile));
		Writer writer = Channels.newWriter(client, StandardCharsets.UTF_8);
		writer.write("Hello Socket!\n");
		writer.close();

		// Accept the server connection and read the message from it
		Reader reader = Channels.newReader(server.accept(), StandardCharsets.UTF_8);
		PrintWriter out = new PrintWriter(System.out, true);
		reader.transferTo(out);
		out.flush();

		// Cleanup
		server.close();
		Files.delete(socketfile);

	}

}
