package com.guru.demo

import scala.util.parsing.combinator._

object Main extends App {
  val ages = Seq(42, 61, 29, 64)
  println(s"The oldest person is ${ages.max}")
}

case class WordFreq(word: String, count: Int) {
  override def toString = "Word <" + word + "> " +
    "occurs with frequency " + count
}

class SimpleParser extends RegexParsers {
  def word: Parser[String]   = """[a-z]+""".r       ^^ { _.toString }
  def number: Parser[Int]    = """(0|[1-9]\d*)""".r ^^ { _.toInt }
  def freq: Parser[WordFreq] = word ~ number        ^^ { case wd ~ fr => WordFreq(wd,fr) }
}

object TestSimpleParser extends SimpleParser {
  def main(args: Array[String]) = {
    parse(freq, "johnny 121") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }
  }
}