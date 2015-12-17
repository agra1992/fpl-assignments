Control.Print.printDepth := 10;

datatype 'a ntree = leaf of 'a | node of 'a ntree list;

fun map(f, [ ]) = [ ]
 | map(f, x::t) = f(x) :: map(f, t); 

fun reduce(f, b, [ ]) = b
 | reduce(f, b, x::t) = f(x, reduce(f, b, t));

fun subst(leaf(t), v1, v2) = 
    if t=v1 then leaf(v2)
    else leaf(t)
    | subst(node(u), v1, v2) = 
        let 
           fun h(w) = subst(w, v1, v2)
        in
            node(map(h, u))
        end;

fun toString(leaf(t)) = 
  let val acc=t in acc end
    | toString(node(u)) = 
        let 
           fun p(z, "") = toString(z) ^ ""
           | p(z,f) = toString(z) ^ " " ^ f
        in
           reduce(p,"", u)
        end;

(*subst(node([leaf("x"), node([leaf("y"), leaf("x"), leaf("x"), leaf("z")])]),"x","w");*)
(*toString(node([leaf("x"), node([leaf("y"), leaf("x"), leaf("x"), leaf("z")])]));*)
