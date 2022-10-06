//> using lib "com.lihaoyi::os-lib::0.8.1"
//> using publish.organization "io.github.alexarchambault"

object Ls {
  def main(args: Array[String]): Unit = {
    val paths =
      if (args.isEmpty) Seq(os.pwd)
      else args.toSeq.map(os.Path(_, os.pwd))
    for (path <- paths) {
      val list = os.list(path)
      for (file <- list if !file.last.startsWith("."))
        println(file.last)
    }
  }
}
