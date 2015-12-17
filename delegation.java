
 	interface IA {
		int f();
		int p(int m);
		int q(int m);
		int get_a1();
		int get_a2();
	}

	interface IB extends IA {
		int g();
		int get_b1();
		int get_b2();
	}

	interface IC extends IB {
		int r();
		int get_c1();
		int get_c2();
	}

	interface ID extends IB {
		int get_d1();
		int get_d2();
	}

	class A2 implements IA {
		int a1 = 1;
	      int a2 = 2;
		IA this2;
		
		public A2(IA s) {this2 = s; }
		
		public int get_a1() {return a1; }
		
		public int get_a2() {return a2; }

		public int f() {
			return a1 + this2.p(100) + this2.q(100);
		}
		public int p(int m) {  // over-ridden
			return this2.p(m);
		}
		public int q(int m) { // over-ridden
			return this2.q(m);
		}
	}

	 class B2 implements IB {
	      int b1 = 10;
	      int b2 = 20;
		  IB this2;
	      A2 super2;
		  
		public B2(IB s) {		// create superclass object
	          this2 = s;
		      super2 = new A2(this2);  // pass subclass object (for efficiency)
		}
		public int get_a1() {    // get method for attribute a1
			return super2.get_a1();
		}
		public int get_a2() {    // get method for attribute a1
			return super2.get_a2();
		}
		public int get_b1() {   // get method for attribute b1
			return b1;
		}
		public int get_b2() {   // get method for attribute b2
			return b2;
		}
		public int f() {        // delegate call for f
			return super2.f();
		}
		public int g() { 		 // define g(); assume q is over-ridden
			return f() + this2.q(200);
		}
		public int p(int m) {  //  over-ridden
		    return m + b1;
		}
		public int q(int m) {  // this will be called from sub-class
			return m + b2;    
		}
	}

	class C2 implements IC {
		int c1 = 100;
	    int c2 = 200;
		B2 super2;
		
		public C2() {
			super2 = new B2(this);
		}
		public int get_a1() {    // get method for attribute a1
			return super2.get_a1();
		}
		public int get_a2() {    // get method for attribute a1
			return super2.get_a2();
		}
		public int get_b1() {   // get method for attribute a11
			return super2.get_b1();
		}
		public int get_b2() {   // get method for attribute a11
			return super2.get_b2();
		}
		public int get_c1() {   // get method for attribute a111
			return c1;
		}
		public int get_c2() {   // get method for attribute a111
			return c2;
		}
		public int f() {   // delegate call for f
			return super2.f();
		}
		public int g() {   // delegate call for g
			return super2.g();
		}
		public int r() {  // define g1
			return super2.f() + super2.g() + c1;
		}
		public int p(int m) {
			return super2.p(m) + super2.q(m) + c2;
		}
		public int q(int m) {  // use the superclass q
			return m + super2.get_a2() + super2.get_b2() + get_c2();
		}
	}
	
	class D2 implements ID {
	    int d1 = 300;	
	    int d2 = 400;
	    IB super2;
	    
	    public D2() {
	    	super2 = new B2(this);
		}
		public int get_a1() {    // get method for attribute a1
			return super2.get_a1();
		}
		public int get_a2() {   // get method for attribute a11
			return super2.get_a2();
		}
	       public int get_b1() {   // get method for attribute a11
			return super2.get_b1();
		}
		public int get_b2() {   // get method for attribute a11
			return super2.get_b2();
		}
		public int get_d1() {   // get method for attribute a111
			return d1;
		}
		public int get_d2() {   // get method for attribute a111
			return d2;
		}
		public int f() {       // delegate call for f
			return super2.f();
		}
		public int g() {       // delegate call for g
			return super2.g();
		}
		public int q(int m) {   // use the suoerclass q
			return super2.q(m);
		}
		public int p(int m) {   
			return m + super2.get_a1() + super2.get_b1() + d1;
		}
		public int r() {
			return super2.f() + super2.g() + d2;
		}
	}
