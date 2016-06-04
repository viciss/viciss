// example of take static closure as parameter
fn call_with_one<F>(some_closure: F) -> i32
	where F: Fn(i32) -> i32 {
		some_closure(1)
	}

// example of take dynamic dispatch closure as paramter
fn call_with_one_dynamic(some_closure: &Fn(i32) -> i32) -> i32 {
	some_closure(1)
}

// example of returning closure
fn factory() -> Box<Fn(i32) -> i32> {
	let num = 5;

	Box::new(move |x| x + num)
}

// an example of general function call
trait Foo {
	fn clone(&self);
}

// both Clone and Foo has defined a clone function
// so, in following code must indicate which clone function
// is used
#[derive(Clone)]
struct Bar;

impl Foo for Bar {
	fn clone(&self) {
		println!("Making a clone of Bar");

		<Bar as Clone>::clone(self);
	}
}

fn main() {
	let plus_two = |x| {
		let mut result: i32 = x;

		result += 1;
		result += 1;

		result
	};

	assert_eq!(4, plus_two(2));

	// example of closure as parameter
	let answer = call_with_one(|x| x + 2);
	assert_eq!(3, answer);

	let answer = call_with_one_dynamic(&|x| x + 2);
	assert_eq!(3, answer);

	let f = factory();
	let answer = f(1);
	assert_eq!(6, answer);

	let bar = Bar;
	Foo::clone(&bar);
	<Bar as Foo>::clone(&bar);
}
