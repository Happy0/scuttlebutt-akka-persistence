name := "scuttlebutt-akka-persistence"

version := "1.0"

scalaVersion := "2.12.8"

resolvers += "jcenter" at "http://jcenter.bintray.com/"
resolvers += "apache-snapshots" at "https://dl.bintray.com/openlawbot/forks/"


resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.5.21"
libraryDependencies += "com.typesafe.akka" %% "akka-persistence-query" % "2.5.21"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.21"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8"
libraryDependencies += "io.vertx" % "vertx-core" % "3.6.2"

libraryDependencies += "org.logl" % "logl-logl" % "0.4.0-24B971-snapshot"
libraryDependencies += "org.logl" % "logl-api" % "0.4.0-24B971-snapshot"

libraryDependencies += "com.github.jnr" % "jnr-ffi" % "2.1.9"
libraryDependencies += "com.github.jnr" % "jffi" % "1.2.18"

libraryDependencies += "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.9.8"

libraryDependencies += "org.openlaw" % "tuweni-scuttlebutt" % "0.8.0"
libraryDependencies += "org.openlaw" % "tuweni-scuttlebutt-rpc" % "0.8.0"
libraryDependencies += "org.openlaw" % "tuweni-scuttlebutt-handshake" % "0.8.0"
libraryDependencies += "org.openlaw" % "tuweni-crypto" % "0.8.0"

updateOptions := updateOptions.value.withLatestSnapshots(false)
