boy(ali).
boy(bing).
boy(charles).
boy(dani).
girl(lola).
girl(mary).
girl(nina).
girl(kari).


biking(B1, G1).
running(B2, G2).
hiking(B3, G3).
surfing(B4, G4).

solve(Answer) :- assumptions(Answer),
       constrainta(Answer),
       constraintb(Answer),
       constraintc(Answer),
       constraintd(Answer),
       constrainte(Answer),!.


assumptions(Answer) :- boy(B1), boy(B2), B1 \== B2,
           boy(B3), B1 \== B3, B2 \== B3,
           boy(B4), B1 \== B4, B2 \== B4, B3 \== B4,
           girl(G1), girl(G2), G1 \== G2,
           girl(G3), G1 \== G3, G2 \== G3,
           girl(G4), G1 \== G4, G2 \== G4, G3 \== G4,
        Answer = [ biking(B1, G1), running(B2, G2),
          hiking(B3, G3), surfing(B4, G4)].


constrainta(Answer) :- member(biking(ali,_), Answer),
 member(hiking(_,mary), Answer).

constraintb(Answer) :- member(running(A,_), Answer),
 member(running(_,B), Answer),
 A \== bing, A \== charles, B \== kari, B \== lola.

constraintc(Answer) :- member(surfing(_,C), Answer), C\==nina.

constraintd(Answer) :- member(running(charles,lola), Answer); member(biking(charles,lola), Answer); member(hiking(charles,lola), Answer); member(surfing(charles,lola), Answer).

constrainte(Answer) :- member(running(dani,D), Answer); member(biking(dani,D), Answer); member(hiking(dani,D), Answer); member(surfing(dani,D), Answer), D \== mary.
