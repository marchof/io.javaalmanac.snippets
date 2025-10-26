package io.javaalmanac.snippets.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

/**
 * Cryptographic signatures are based on public/private key pairs. In contrast
 * to [MACs](../messageauthenticationcode/) they allow anyone to verify the
 * integrity of a message with the public key. Signatures are the core building
 * blocks in cryptography to create chains of trust. For example SSL
 * certificates are signed by certification authorities. By knowing the public
 * keys of the trusted certification authorities a web browser can verify the
 * certificates offered by a web site.
 * 
 * @title Message Signature
 * @category api.security
 * @since 1.1
 */
public class MessageSignature {

	void main() throws Exception {

		KeyPair keypair = KeyPairGenerator.getInstance("RSA").genKeyPair();

		Signature signature = Signature.getInstance("SHA256withRSA");

		// Sign a message with the private key:
		signature.initSign(keypair.getPrivate());
		signature.update("The price is 39.99€".getBytes());
		byte[] signed = signature.sign();

		// Verify the message with the public key:
		signature.initVerify(keypair.getPublic());
		signature.update("The price is 39.99€".getBytes());
		IO.println(signature.verify(signed));

		// When the message is altered the signature cannot be verified:
		signature.initVerify(keypair.getPublic());
		signature.update("The price is 29.99€".getBytes());
		IO.println(signature.verify(signed));

	}

}
