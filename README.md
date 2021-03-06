# breaking-knapsack-encryption
My COMP546 (Algorithm Design and Analysis) Course Project while I was doing my PhD at KU. It is the Java implementation of my designed algorithm to break an knapsack encrypted user input password, and reveal the plaintext.

Password Cracking problem has been introduced by the Princeton university in 2003. The Knapsack encryption is a public key encryption scheme. Like all the encryption scheme, the Knapsack encryption consist of three polynomial algorithms: KeyGen, Encryption, Decryption. These algorithms has been described in details in the following subsection. To facilities understanding the scheme, I divided the KeyGen algorithm into two separate algorithms: PubKeyGen and PrivKeyGen generate the public key and secret key respectively.

To encrypt a message, the Encryption algorithm employs the public key on the message and returns the encrypted message. This encrypted message is called the Ciphertext. Decrypting the ciphetext with the public key is not efficient and takes a lot of time. In the other word, decrypting the message with the public key is an exponential algorithm. As the size of the public key grows linearly, the time needed to decrypt the ciphertext with the public key grows exponentially. 

To decrypt the ciphertext and obtain the message, the Decryption algorithm should be ran on the ciphertext by employing the secret key. Using the secret key, the Decryption algorithm could decrypt the ciphertext and obtain a message in the polynomial amount of time. This justifies the name of the keys; public key is used only for the encryption, while decryption is hard using that. Therefore it could be public and even the adversary could have and use that! However, the secret key should be secret since it could easily decrypt the message. 

# Project Documentation
The full project documentation is available at: https://archive.org/details/COMP546ProjectReportPasswordCracking

# License
Apachea Version 2.0 
