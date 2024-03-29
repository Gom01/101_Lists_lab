import java.io.IOException

class Node(var item : String, var next : Node){}
object Node extends App{
  var head : Node = new Node("Tokyo",new Node("Paris", new Node("Milan", null)))
}



class LinkedList(var head : Node = null){
  def addToStart(s : String) : Unit =
  {
     head = new Node(s, head)
  }
  def getSize(): Int = {
    var counter = 0
    if(head != null) {
      var actualNode = head
      while (actualNode != null) {
        counter += 1
        actualNode = actualNode.next
      }
      return (counter)
    }
    return(counter)
  }
  override def toString : String = {
    var temp : String = s"List Content (Size ${getSize()}) : "
    var actualNode = head
    while(actualNode != null){
      temp += actualNode.item + "->"
      actualNode = actualNode.next
    }
    temp += "null"

    return(temp)
  }
  def removeFirstElement() : String = {
      var actualnode = head
      if(actualnode != null) {
        head = actualnode.next
        if(head == null){
          return(null)
        }
        return (head.item)
      }
    return(null)
  }

  def getLastElement(): Node = {
    var actualnode = head
    if(actualnode != null) {
      while(actualnode.next != null){
        actualnode = actualnode.next
      }
      return(actualnode)
    }
    return(null)
  }

  def addToEnd(element : String): Unit = {
    if(getLastElement() != null){
        var lastItem: String = getLastElement().item
        var actualnode = head
        while (actualnode.item != lastItem) {
          actualnode = actualnode.next
        }
        actualnode.next = new Node(element, null)
    }
    else {
      head = new Node(element, null)
    }
  }

  def isPresent(e: String): Boolean = {
    var actualnode = head
    while(actualnode != null){
      if(actualnode.item == e){
        return(true)
      }
      actualnode = actualnode.next
    }
    return(false)
  }

  def findElement(s : String): Node = {
    if(isPresent(s)) {
      var actualnode = head
      if (actualnode != null) {
        while (actualnode.item != s) {
          actualnode = actualnode.next
        }
        return (actualnode)
      }
    }
    return(null)
  }

  def swapElements(s1 : String, s2 : String): Unit = {
    if((s1 != null) && (s2 != null)) {
      if ((isPresent(s1)) && (isPresent(s2))) {
        var e1: Node = findElement(s1)
        var e2: Node = findElement(s2)
        var temp: String = ""
        temp = e2.item
        e2.item = e1.item
        e1.item = temp
      }
    }
  }

  def removeLastElement(): Unit = {
    if (getSize() == 1) {
      head = null
    }

    if(head != null) {
      var lastItem: String = getLastElement().item
      var actualnode = head
      var previousNode = head
      while (actualnode.item != lastItem) {
        previousNode = actualnode
        actualnode = actualnode.next
      }
      previousNode.next = null
    }
  }

  def removeElement(s: String): Unit = {
    if(isPresent(s)) {
      if(getSize() == 1 ){
        removeFirstElement()
        return
      }
      if(getLastElement().item == s){
        removeLastElement()
        return
      }
      if(head.item == s){
        removeFirstElement()
        return
      }
      var elementItem: String = findElement(s).item
      if (elementItem != null) {
        var actualnode = head
        var previousNode = head
        while (actualnode.item != elementItem) {
          previousNode = actualnode
          actualnode = actualnode.next
        }
        previousNode.next = actualnode.next
      }
    }
  }

  def insertAfter(before: String, after: String): Unit = {
    if (isPresent(before) || isPresent(after)) {
      if(getSize() == 1){
        head.next = new Node(after,null)
        return
      }
      var elementItem: String = findElement(before).item
      var actualnode = head
        var previousNode = head
        while (actualnode.item != elementItem) {
          previousNode = actualnode
          actualnode = actualnode.next
        }
        actualnode.next = new Node(after, actualnode.next)
    }
  }


}

object LinkedList extends App {
  var flightList:LinkedList = new LinkedList()
  flightList.addToStart("Geneve")
  println(flightList)
  flightList.insertAfter("Geneve", "Paris")
  println(flightList)
  println(flightList.getSize())

}
