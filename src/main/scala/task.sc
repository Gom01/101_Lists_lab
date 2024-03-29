var names: List[String] = List("Anna", "Paul", "Alex", "Olivier")
println(names.mkString(","))

if(names.contains("Paul")){
  println("There is Paul inside the list")
}

var namesWithoutPaul : List[String] = List()
namesWithoutPaul = names.filter(_!="Paul")
println(namesWithoutPaul)

