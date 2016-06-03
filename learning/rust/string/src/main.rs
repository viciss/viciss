fn takes_slice(slice: &str)
{
	println!("Got: {}", slice);
}

fn indexing() {
	let hachiko = "忠犬ハチ公";

	for b in hachiko.as_bytes() {
		print!("{}, ", b);
	}

	println!("");

	for c in hachiko.chars() {
		print!("{}, ", c);
	}

	println!("");

	let dog = hachiko.chars().nth(1);
//	print!("dog is {}", dog);
}

fn concatenation() {
	let hello = "Hello ".to_string();
	let world = "world!";

	let hello_world = hello + world;

	let world_string = "world!".to_string();
	let hello_world_string = hello + &world;
}

fn main() {
	let mut s = "Hello".to_string();
	println!("{}", s);

	takes_slice(&s);

	s.push_str(", world.");
	println!("{}", s);

	indexing();
	concatenation();
}
