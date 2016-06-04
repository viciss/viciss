struct Circle {
	x: f64,
	y: f64,
	radius: f64
}

trait HasArea {
	fn area(&self) -> f64;
}

impl HasArea for Circle {
	fn area(&self) -> f64 {
		std::f64::consts::PI * (self.radius * self.radius)
	}
}

struct Square {
	x: f64,
	y: f64,
	side: f64
}

impl HasArea for Square {
	fn area(&self) -> f64 {
		self.side * self.side
	}
}

// not a good design
// implement traits for primitive type
impl HasArea for i32 {
	fn area(&self) -> f64 {
		println!("this is silly");

		*self as f64
	}
}

fn print_area<T: HasArea>(shape: T) {
	println!("This shape has an area of {}", shape.area());
}

use std::fmt::Debug;
fn foo<T: Clone, K: Clone + Debug>(x: T, y: K) {
	x.clone();
	y.clone();
	println!("{:?}", y);
}

fn bar<T, K>(x: T, y: K) where T: Clone, K: Clone + Debug {
	x.clone();
	y.clone();
	println!("{:?}", y);
}


trait ConvertTo<Output> {
	fn convert(&self) -> Output;
}

impl ConvertTo<i64> for i32 {
	fn convert(&self) -> i64 {*self as i64}
}

fn normal<T: ConvertTo<i64>>(x: &T) -> i64 {
	x.convert()
}

fn inverse<T>() -> T
		where i32: ConvertTo<T> {
			42.convert()
		}

trait Foo {
	fn is_valid(&self) -> bool;

	fn is_invalid(&self) -> bool 
	{ 
		!self.is_valid()
	}

	fn foo(&self) {

	}
}

struct UseDefault;

impl Foo for UseDefault {
	fn is_valid(&self) -> bool {
		println!("called useDefault.is_valid");
		true
	}
}

struct OverrideDefault;

impl Foo for OverrideDefault {
	fn is_valid(&self) -> bool {
		println!("Called OverrideDefault.is_valid");
		true
	}

	fn is_invalid(&self) -> bool {
		println!("Called OverrideDefault.is_invalid!");
		true
	}
}

trait FooBar : Foo {
	fn foobar(&self);
}

struct Baz;

impl Foo for Baz {
	fn foo(&self) {
		println!("foo");
	}

	fn is_valid(&self) -> bool {
		true
	}
}

impl FooBar for Baz {
	fn foobar(&self) {
		println!("foobar");
	}
}

// sample for Drop trait
struct HasDrop;
impl Drop for HasDrop {
	fn drop(&mut self) {
		println!("Dropping");
	}
}

// sample for drop sequence
struct Firework {
	strength: i32
}

impl Drop for Firework {
	fn drop(&mut self) {
		println!("BOOM times {}!!!", self.strength);
	}
}

fn main() {
	let x = HasDrop;
	let firecracker = Firework { strength: 1};
	let tnt = Firework { strength: 100 };

	let c = Circle {
		x: 0.0f64,
		y: 0.0f64,
		radius: 1.0f64
	};

	let s = Square {
		x: 0.0f64,
		y: 0.0f64,
		side: 1.0f64
	};

	print_area(c);
	print_area(s);
	5.area();

	foo("Hello", "world");
	bar("Hello", "world");

	let default = UseDefault;
	assert!(!default.is_invalid());

	let over = OverrideDefault;
	assert!(over.is_invalid());

	let baz = Baz;
	baz.foobar();

}
