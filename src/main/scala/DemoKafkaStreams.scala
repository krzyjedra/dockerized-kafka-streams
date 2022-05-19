import java.util.Properties

object DemoKafkaStreams extends App {

  import org.apache.kafka.common.serialization.Serdes
  import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig}
  val bootstrapServers = sys.env.getOrElse("KRZYSIEK_BOOTSTRAP_SERVERS", ":9092")
  val props = new Properties()
  props.put(StreamsConfig.APPLICATION_ID_CONFIG, "demo-ks")
  props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
  props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass)
  props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String.getClass)

  val builder = new StreamsBuilder
  builder.stream[String, String]("input").mapValues((value: String) => String.valueOf(value.length)).to("output")

  val streams = new KafkaStreams(builder.build, props)
  streams.start()
}