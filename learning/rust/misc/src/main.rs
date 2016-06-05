use std::ops::Add;
use std::ops::Deref;

struct Foo<T: ?Sized> {
	f: T
}

// sample for overwrite "+"
#[derive(Debug)]
struct Point {
	x: i32,
	y: i32
}

impl Add for Point {
	type Output = Point;

	fn add(self, other: Point) -> Point {
		Point { x: self.x + other.x, y: self.y + other.y }
	}
}

impl Add<i32> for Point {
	type Output = f64;

	fn add(self, rhs: i32) -> f64 {
		(self.x + rhs) as f64
	}
}

// sample for deref
struct DerefExample<T> {
	value: T
}

impl<T> Deref for DerefExample<T> {
	type Target = T;

	fn deref(&self) -> &T {
		&self.value
	}
}

fn foo_for_deref(c: &char) {
	println!("{:?}", c);
}

fn main() {
	let p1 = Point { x: 1, y: 0 };
	let p2 = Point { x: 2, y: 3 };

	let p3 = p1 + p2;

	println!("{:?}", p3);

	let x: f64 = p3 + 2i32;
	println!("{:?}", x);

	let x = DerefExample { value: 'a' };
	assert_eq!('a', *x);
	foo_for_deref( &x );
}
