# scala.lisp: A Toy LISP Interpreter in Scala.

This repository contains the source code for an extremely simple basis for a LISP interpreter in Scala.

## Building Instructions

   Prompt% scalac lisp.scala

## Sample Output

   `Prompt% scala lisp`
   `(1 . (2 . (3 . NIL)))`
   `(NIL . NIL)`
   `eq(a, a) ==> true`
   `eq(a, b) ==> false`
   `eq(b, b) ==> true`
   `eq(a, d) ==> false`
   `eq(d, e) ==> false`
   `eq(d, d) ==> true`
   `c ==> (1 . 2)`
   `x ==> (print . (1 . NIL))`
   `eval(x) ==> 1()`
   `Prompt%`

## Future Directions

At this point, the program is simply a toy proof-of-concept of embedding the primitives of a LISP-like language in a type-safe language like Scala.

* Adding a Read-Eval-Print loop would make it a "real" interactive interpreter.

* Adding data types (e.g., `lambda`) and primitive functions are needed to fill out the langauge.

## License

This code is published under the MIT License (i.e., the "Expat License".) Please see the file `LICENSE`.

## Enjoy!!
