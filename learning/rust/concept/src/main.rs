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