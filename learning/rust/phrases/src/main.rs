extern crate phrases;

//use phrases::english::greetings;
//use phrases::english::farewells;
use phrases::english::{greetings, farewells};
use phrases::japanese;

use std::mem;

fn main() {
	println!("Hello in English: {}", greetings::hello());
	println!("Goodbye in English: {}", farewells::goodbye());

	println!("Hello in Japanese: {}", japanese::hello());
	println!("Goodbye in Japanese: {}", japanese::goodbye());

	const N: i32 = 5;
	static M: i32 = 5;
	static NAME: &'static str = "Steve";

	static mut O: i32 = 5;
	unsafe {
		O += 1;
		println!("O: {}", O);
	}

	let x: i32 = 5;
	let y = x as i64;

	unsafe {
		let a = [0u8, 0u8, 0u8, 0u8];
		let b = mem::transmute::<[u8; 4], u32>(a);
	}
}