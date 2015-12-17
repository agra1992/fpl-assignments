int sigma(int *k, int low, int high, int expr()) {
  int sum = 0;
  for (*k=low; *k<=high; (*k)++) {
    sum = sum + expr();
  }
  return sum;
}
int main(){
  int i, j, k;
  int thk3() {return j*k - i;}
  int thk2() {return (i+j)*sigma(&k,0,4,thk3);}
  int thk1() {return i*sigma(&j,0,4,thk2);}
  printf("%d\n", sigma(&i,0,4, thk1));
}
