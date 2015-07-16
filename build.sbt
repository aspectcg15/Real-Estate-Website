name := """Real Estate Website"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.10.4"

//EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
//EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes

libraryDependencies ++= Seq(
  filters,
  javaJdbc,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.36",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.3.0",
  "org.apache.kafka" % "kafka_2.10" % "0.8.2.1",
  "org.scala-lang" % "scala-library" % scalaVersion.value
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


fork in run := true