scalaVersion := "2.11.8"

organization := "com.github.walfie"

name := "pogoprotos"

// Required for publishing on Bintray
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

libraryDependencies ++= Seq(
  // Enable custom package options
  "com.trueaccord.scalapb" %% "scalapb-runtime" % "0.5.34" % ScalaPbPlugin.protobufConfig
)

// ScalaPB plugin
import com.trueaccord.scalapb.ScalaPbPlugin

ScalaPbPlugin.protobufSettings
inConfig(ScalaPbPlugin.protobufConfig) {
  import ScalaPbPlugin.{runProtoc, flatPackage}

  Seq(
    flatPackage := true,
    runProtoc := { args =>
      com.github.os72.protocjar.Protoc.runProtoc("-v300" +: args.toArray)
    }
  )
}

// sbt-site plugin
site.settings
site.includeScaladoc()

// sbt-ghpages plugin
ghpages.settings
git.remoteRepo := "git@github.com:walfie/pogoprotos.scala.git"

// sbt-release plugin
// Remove `pushChanges` from the release process, since it requires an upstream.
// After a release, commits/tags will need to be pushed manually.
import ReleaseTransformations._
releaseProcess -= pushChanges

