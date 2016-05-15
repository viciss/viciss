fn main() {
	// define a variable
//	let x = 5;
	// this is wrong!
	// coz x is immutable
//	x = 10;

	// define a immutable variable
	let mut x = 5;
	x = 10;

	// define a tuple
	let (y,z) = (1,2);

	let mut z = 5;
	let w = ( z = 6 ); // w has the value `()`, not `6`

	// w cannot be printed, as it is a tuple
	// println!("w is: {}", w);

	// define a variable with type
	let a: i32 =5;

	print_number(5);
	print_sum(5, 6);

	add_one(6);

	array_sample();

	slice_sample();

	tuple_sample();

	if_sample();

	while_sample();

	for_sample();

	// sample of function pointer
	let fnpointer: fn(i32) -> i32 = add_one;

	let b: i32 = diverges();
	let c: String = diverges();
}

fn print_number(x: i32) {
	println!("x is: {}", x);
}

fn print_sum(x: i32, y: i32) {
	println!("sum is: {}", x + y);
}

fn add_one(x: i32) -> i32 {
	x + 1
}


// following is also accepted, but we prefer above one
fn foo(x: i32) -> i32 {
	return x + 1;
}

fn diverges() -> ! {
	panic!("This function never returns!");
}
fn array_sample() {
	let a = [1,2,3];
	println!("a has {} elements", a.len());

	let mut m = [1,2,3];

	let aa = [0; 20]; // aa: [i32;20]
	let names = ["Graydon", "Brian", "niko"];
	println!("The second name is: {}", names[1]);
}

fn slice_sample() {
	let a = [0,1,2,3,4];
	let middle = &a[1..4];
	let complete = &a[..];
}

fn tuple_sample() {
	let x = (1, "hello");
	let y: (i32, &str) = (1, "hello");

	let mut z = (1,2);
	let w = (2,3);

	z = w;

	let (a, b, c) = (1,2,3);
	println!("a is {}", a);

	let tuple = (1,2,3);
	let tx = tuple.0;
	let ty = tuple.1;
	let tz = tuple.2;

	println!("tx is {}", tx);
}

fn if_sample() {
	let x = 5;

	if x == 5 {
		println!("x is five!");
	}
	else if x == 6 {
		println!("x is six!");
	}
	else {
		println!("x is not five or six :(");
	}

	let y = if x == 5 {
		10
	} else {
		15
	};

	let z = if x == 5 { 10 } else { 15 };
}

fn while_sample() {
	let mut x = 5;
	let mut done = false;

	while !done {
		x += x - 3;

		println!("{}", x);

		if x % 5 == 0 {
			done = true;
		}
	}
}

fn for_sample() {
	for (i, j) in (5..10).enumerate() {
		println!("i = {} and j = {}", i, j);
	}

	for x in 0u32..10 {
		if x % 2 == 0 { continue; }

		println!("{}", x);
	}

	'outer: for x in 0..10 {
		'inner: for y in 0..10 {
			if x % 2 == 0 { continue 'outer; }
			if y % 2 == 0 { continue 'inner; }
			println!("x: {}, y:{}", x, y);
		}
	}
}