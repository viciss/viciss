struct Circle {
	x: f64,
	y: f64,
	radius: f64
}

impl Circle {
	fn area(&self) -> f64 {
		std::f64::consts::PI * (self.radius * self.radius)
	}

	fn grow(&self) -> Circle {
		Circle {x: self.x, y: self.y, radius: (self.radius * 10.0)}
	}

	fn reference(&self) {
		println!("taking self by reference!");
	}

	fn mutable_reference(&mut self) {
		println!("taking self by mutable reference!");
	}

	fn takes_ownership(self) {
		println!("taking ownership of self!");
	}

	fn new(x: f64, y: f64, radius: f64) -> Circle {
		Circle { x: x, y: y, radius: radius}
	}
}

struct CircleBuilder {
	coordinate: f64,
	radius: f64
}

impl CircleBuilder {
	fn new() -> CircleBuilder {
		CircleBuilder { coordinate: 0.0, radius: 0.0 }
	}

	fn coordinate(&mut self, coordinate: f64) -> &mut CircleBuilder {
		self.coordinate = coordinate;
		self
	}

	fn radius(&mut self, radius: f64) -> &mut CircleBuilder {
		self.radius = radius;
		self
	}

	fn finalize(&self) -> Circle {
		Circle { x: self.coordinate, y: self.coordinate, radius: self.radius}
	}
}
fn main() {
//	let c = Circle{x: 0.0, y: 0.0, radius: 2.0};
//	let c = Circle::new(0.0, 0.0, 2.0);
	let c = CircleBuilder::new()
	.coordinate(10.0)
	.radius(5.0)
	.finalize();

	println!("{}", c.area());

	let d = c.grow().area();
	println!("{}", d);
}
