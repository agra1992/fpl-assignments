def flatten(l):
  if isinstance(l, list):
    for e in l:
      for x in flatten(e):
        yield x
        
  else: yield l
  
l = [1, [[[2]]], [3,4], [5,[6]]]

print([x for x in flatten(l)])
