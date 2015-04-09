# jcardmock
Mock implementation of the Java Card API 3.0.4 in order to test Java Card applet code without a card or simulator.
It runs the Java Card API 3.0.4 in a normal Java Virtual Machine.
The purpose is to allow for unit tests for Java Card applets with normal test frameworks like JUnit or TestNG in a normal Java Virtual Machine in order to have a fast TDD Red-Green-Refactor cycle time.
This can lead to increased development speed and reduced development costs of Java Card applets.

## Roadmap

### Current Releases
none yet

### Future Releases
* 1.0.0 Implementation of `javacard.framework`
* 1.1.0 Implementation of `javacard.security`
* 1.2.0 Implementation of `javacard.framework.service`
* 1.3.0 Implementation of `javacardx.annotations`
* 1.4.0 Implementation of `javacardx.framework.util.intx`
* 1.5.0 Implementation of `javacardx.framework.util`
* 1.6.0 Implementation of `javacardx.framework.string`
* 1.7.0 Implementation of `javacardx.framework.math`
* 1.8.0 Implementation of `javacardx.framework.tlv`
* 1.9.0 Implementation of `javacardx.external`
* 1.10.0 Implementation of `javacardx.apdu`
* 1.11.0 Implementation of `javacardx.crypto`
* 1.12.0 Implementation of `javacardx.biometry`
* 1.13.0 Implementation of Transactions
* 1.14.0 Implementation of Firewall

Disclaimer: The roadmap may change any time without further notice.
