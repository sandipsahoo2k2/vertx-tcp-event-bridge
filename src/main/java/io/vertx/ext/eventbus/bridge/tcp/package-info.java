/*
 * Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

/**
 * = Vert.x-tcp-eventbus-bridge
 * :toc: left
 *
 * Vert.x-tcp-eventbus-bridge is a TCP bridge to Vert.x EventBus. To use this project, add the following
 * dependency to the _dependencies_ section of your build descriptor:
 *
 * Maven (in your `pom.xml`):
 *
 * [source,xml,subs="+attributes"]
 * ----
 * <dependency>
 *   <groupId>${maven.groupId}</groupId>
 *   <artifactId>${maven.artifactId}</artifactId>
 *   <version>${maven.version}</version>
 * </dependency>
 * ----
 *
 * Gradle (in your `build.gradle` file):
 *
 * [source,groovy,subs="+attributes"]
 * ----
 * compile '${maven.groupId}:${maven.artifactId}:${maven.version}'
 * ----
 *
 * The TCP EventBus bridge is built on top of TCP, meaning that any application that can
 * create TCP sockets can interact with a remote Vert.x instance via its event bus.
 *
 * The main use case for the TCP bridge _versus_ the SockJS bridge is for applications that are more
 * resource-constrained and that need to be lightweight since the whole HTTP WebSockets is replaced with plain TCP sockets.
 *
 * It remains of course useful even for applications that don't have tight resource constraints:
 * the protocol is simple enough to efficiently provide an integration interface with non-JVM
 * applications.
 *
 * The protocol has been kept as simple as possible and communications use Frames both ways.
 * The structure of a Frame looks like this:
 *
 * ----
 * <Length: uInt32><{
 *    type: String,
 *    address: String,
 *    (replyAddress: String)?,
 *    headers: JsonObject,
 *    body: JsonObject
 * }: JsonObject>
 * ----
 *
 * The message consists of a JSON document that may or may not have been minified.
 * The message must be prefixed by a _big endian_ 32 bits positive integer (4 bytes) that indicates
 * the full length of the JSON document, in bytes.
 *
 * The message `type` can be the following for messages sent by the TCP client:
 *
 * 1. `send` to send a message to an `address`,
 * 2. `publish` to publish a message to an `address`,
 * 3. `register` to subscribe to the messages sent or published to an `address`,
 * 4. `unregister` to unsubscribe to the messages sent or published to an `address`.
 *
 * Note that the `replyAddress` field is optional and may only be used for a `send` message.
 * A message with that field is expected to _eventually_ receive a message back from the server
 * whose `address` field will be that of the original `replyAddress` value.
 *
 * The server posts messages back to the client, and they can be of the following `type`:
 *
 * 1. `message` for messages sent or published to an `address`, or
 * 2. `err` to indicate an error (the `body` shall contain details).
 *
 * An example NodeJS client is available in the source of the project.
 * This client uses the same API as the SockJS
 * counter part so it should make it easier to switch between the TCP and SockJS implementations.
 *
 * An example on how to get started with this bridge could be:
 *
 * [source,$lang]
 * ----
 * {@link examples.TCPBridgeExamples#example1}
 * ----
 *
 */
@ModuleGen(name = "vertx-tcp-eventbus-bridge", groupPackage = "io.vertx.ext")
@Document(fileName = "index.adoc")

package io.vertx.ext.eventbus.bridge.tcp;

import io.vertx.codegen.annotations.ModuleGen;
import io.vertx.docgen.Document;
