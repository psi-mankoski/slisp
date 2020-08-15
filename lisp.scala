/*
    File:   lisp.scala
    Author: ***PSI***
    Date:   Mon Apr 21 00:27:55 2014
   
    Description:
       A simple LISP interpreter in Scala.
*/

object lisp {

    class Atom(name: String) {
       var value: Any = nil
       def SymbolName = name
       def Setq(x: Any) {
          value = x
       }
    }

    class Nil extends Atom("NIL") {
    }

    var nil = new Nil()

    class Cell(first: Any, second: Any) {
        def Car = first
        def Cdr = second
    }

    def cons(first: Any, second: Any): Cell = new Cell(first, second)

    def nullp(x: Any): Boolean = x match {
        case _: Nil => true
        case _ => false
    }

    def atom(x: Any): Boolean = x match {
        case _: Atom => true
        case _ => false
    }

    def eq(x: Any, y: Any): Boolean = x == y

    def car(x: Cell) = x.Car

    def cdr(x: Cell) = x.Cdr

    def setq(x: Atom, y: Any) = x.Setq(y)

    def Print(x: Any): Unit = x match {
        case y: Cell => {
	    print('('); Print(car(y)); print(" . "); Print(cdr(y)); print(')');
        }
	case y: Nil => Print(y.SymbolName)
	case y: Atom => Print(y.value)
        case y: Any => print(y)
    }

    def Println(x: Any) = {
        Print(x)
        println()
    }

    def eval(x: Any): Any = x match {
       case y: Int => y
       case y: String => y
       case y: Nil => y.SymbolName
       case y: Atom => y.value
       case y: Cell => apply(eval(car(y)), cdr(y))
    }

    def apply(x: Any, y: Any): Any = x match {
       case z: String => z match {
          case "print" => y match {
             case w: Cell => Print(car(w))
             case _ => "Apply Arg Error"
          }
       }
       case _ => "Apply Func Error"
    }

    def main(argv: Array[String]) {
	val a = new Atom("A")
        val b = new Atom("B")
	val c = new Atom("C")

        val d = cons(1, cons(2, cons(3, nil)))
	Println(d)

        val e = cons(a, b)
	Println(e)

	print("eq(a, a) ==> "); println(eq(a, a))
	print("eq(a, b) ==> "); println(eq(a, b))
	print("eq(b, b) ==> "); println(eq(b, b))
	print("eq(a, d) ==> "); println(eq(a, d))
	print("eq(d, e) ==> "); println(eq(d, e))
	print("eq(d, d) ==> "); println(eq(d, d))

	setq(a, 1)
        setq(b, 2)
        setq(c, e)

        print("c ==> "); Println(c)

        var x = cons("print", cons(a, nil))
        print("x ==> "); Println(x)
        print("eval(x) ==> "); Println(eval(x))
    }
}
