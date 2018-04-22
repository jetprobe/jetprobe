package com.jetprobe.core.runner

import java.io.File

/**
  * @author Shad.
  */
case class CmdConfig(jobJarPath : Option[File] = None, configFile : String = "scenario.yml", reportPath : String = "./report.html")

object CmdConfig {

  val parser = new scopt.OptionParser[CmdConfig]("jetprobe") {
    head("jetprobe", "0.1-SNAPSHOT")

    opt[File]('j', "jar").valueName("<file>").
      action( (x, c) => c.copy(jobJarPath = Some(x)) ).
      text("Path of jar is required")

    opt[String]('c', "config").required().valueName("<config>").
      action( (x, c) => c.copy(configFile = x) ).
      text("Yaml config file path")

    opt[String]('r', "reportPath").valueName("<path>").
      action( (x, c) => c.copy(reportPath = x) ).
      text("Report output file path")

    help("help").text("prints this usage text")

  }

}
