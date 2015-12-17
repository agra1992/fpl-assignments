occurs_free_in(X, v(X)).

occurs_free_in(X, l(Y,T)) :- X \== Y,occurs_free_in(X, T).

occurs_free_in(X, a(T1,T2)) :- occurs_free_in(X, T1);occurs_free_in(X, T2).

is_abstraction(l(Y,T)).

betareduction(a(B1,B2)):- is_abstraction(B1);betareduction(B1);betareduction(B2).
betareduction(l(_,B)):-betareduction(B).

etareduction(l(_,B)):- etareduction(B).
etareduction(l(Y,a(B,A))):-(Y == v(B)), \+occurs_free_in(A,B);etareduction(A);etareduction(B).
etareduction(a(B1,B2)):- etareduction(B1);etareduction(B2).

reducible(T):-betareduction(T);etareduction(T).

norm(T):- \+etareduction(T),\+betareduction(T).
