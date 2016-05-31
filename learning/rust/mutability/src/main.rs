use std::sync::Arc;
use std::cell::RefCell;
use std::cell::Cell;

#[derive(Debug)]
struct Point {
    x: i32,
    y: i32
}

#[derive(Debug)]
struct Point_Cell {
    x: i32,
    y: Cell<i32>
}

struct Point3d {
	x: i32,
	y: i32,
	z: i32
}

fn main() {
	// example of exterior mutability
	let x = Arc::new(5);
	let y = x.clone();

	// example of interior mutability
	let z = RefCell::new(42);
	let w = z.borrow_mut();

	// example of field level mutability
	let mut a = Point{x: 5, y: 6};
	a.x = 10;

	let point = Point_Cell{x: 5, y: Cell::new(6)};

	point.y.set(7);
	println!("y: {:?}", point.y);

	// example of update syntax
	let mut point3d = Point3d{x: 0, y: 0, z: 0};
	point3d = Point3d{y: 1, .. point3d};
}
