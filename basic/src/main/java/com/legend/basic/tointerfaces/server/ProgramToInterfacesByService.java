package com.legend.basic.tointerfaces.server;

import com.legend.basic.tointerfaces.common.Language;

/**
 * program to interfaces, not implementations
 *
 * Interfaces are just contracts or signatures and they don't know anything about implementations.
 * Coding against interface means, the client code always holds an Interface object which is supplied by a factory.
 * Any instance returned by the factory would be of type Interface which any factory candidate class must have implemented.
 * This way the client program is not worried about implementation and the interface signature determines
 * what all operations can be done. This can be used to change the behavior of a program at run-time.
 * It also helps you to write far better programs from the maintenance point of view.
 */

/**
 *  I have updated the example above and added an abstract Speaker base class.
 *  In this update, I added a feature to all Speakers to "SayHello".
 *  All speaker speak "Hello World". So that's a common feature with similar function.
 *  Refer to the class diagram and you'll find that Speaker abstract class implement ISpeaker interface
 *  and marks the Speak() as abstract which means that the each Speaker implementation is responsible for
 *  implementing the Speak() method since it varies from Speaker to Speaker.
 *  But all speaker say "Hello" unanimously. So in the abstract Speaker class we define a method
 *  that says "Hello World" and each Speaker implementation will derive the SayHello() method.
 *
 *  Consider a case where SpanishSpeaker cannot Say Hello so in that case you can override the SayHello() method
 *  for Spanish Speaker and raise proper exception.
*/

public class ProgramToInterfacesByService {







}
