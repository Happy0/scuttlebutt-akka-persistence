# Akka persistence Scuttlebutt Driver (Journal + Read Journal)


# Usage

Add the library as a dependency:

```
"default"                %% "scuttlebutt-akka-persistence" % "0.1",
```

Configure akka to use the scuttlebutt driver for the backend for persistence by adding the following to your akka configuration
(e.g. in `application.conf`)

```
akka.persistence.journal.plugin = "scuttlebutt-journal"

```

To configure a `ReadJournal` to use this library:

```
PersistenceQuery(actorSystemProvider.get()).readJournalFor[ScuttlebuttReadJournal](
    "org.openlaw.scuttlebutt.journal.persistence")
}

```

# Configuration

The following values can be configured:

```

secret {
    # Defaults to ~/.ssb/secret
    path: "/path/to/scuttlebutt/secret/file"
}

# The scuttlebot host
host = "localhost"
# The scuttlebot port
port = 8008
# The network key (defaults to the default key used by scuttlebutt applications)
networkKey = "1KHLiKZvAvjbY1ziZEHMXawbCEIM6qwjCDm3VYRan/s="
}
```

# Event Adapters

By default, the plugin serializes and deserializes the event data from JSON by recording the class name of the persisted
event, and deserializing to this class using [Jackson's objectmapper](https://www.baeldung.com/jackson)

If these classes change package or name, or the schema for the application evolves, it may be necessary to write a
custom serializer using akka's [Event Adapter](https://doc.akka.io/docs/akka/2.5.3/scala/persistence.html#event-adapters) system.

* Note: * the `fromJournal` method will receive a type of (JsonNode)[https://fasterxml.github.io/jackson-databind/javadoc/2.2.0/com/fasterxml/jackson/databind/JsonNode.html].
If the raw JSON is preferred to use with another serialization library, `.toString()` can be called on this object.

The plugin can be configured to use an event adapter by modifying your `application.conf`:

```

scuttlebutt-journal {

  event-adapters {
    event-adapter-name = "<package.of.adapter.AdapterClassName"
  }

  event-adapter-bindings {
    "com.fasterxml.jackson.databind.JsonNode" = event-adapter-name
  }

}

```

# Required scuttlebot plugins

The following scuttlebot plugins are required to index and query the persistence data:

`ssb-query` ( https://github.com/ssbc/ssb-query ) - `ssb-server plugin-install ssb-query`

`ssb-akka-persistence-index` ( https://github.com/openlawteam/scuttlebutt-akka-persistence-index ) - `ssb-server plugin-install --from </path/to/scuttlebutt-akka-persistence-index`