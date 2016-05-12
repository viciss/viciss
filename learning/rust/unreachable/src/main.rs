use Event::NewRelease;

enum Event {
	NewRelease
}

fn probability(_: &Event) -> f64 {
	0.95
}

fn descriptive_probability(event: Event) -> &'static str {
	match probability(&event) {
		1.00 => "certain",
		0.00 => "impossible",
		0.00 ... 0.25 => "very unlikely",
		0.25 ... 0.50 => "unlikely",
		0.50 ... 0.75 => "likely",
		0.75 ... 1.00 => "very likely",
		_ => unreachable!()
	}
}

fn main() {
    println!("{}", descriptive_probability(NewRelease));

    let version = parse_version(&[1,2,3,4]);
    match version {
    	Ok(v) => {
    		println!("working with version: {:?}", v);
    	}
    	Err(e) => {
    		println!("error parsing header: {:?}", e);
    	}
    }

//    let info : Info = {"falcon", 10, 1};
//    write_info(info);
}

#[derive(Debug)]
enum Version {Version1, Version2}

#[derive(Debug)]
enum ParseError {InvalidHeaderLength, InvalidVersion}

fn parse_version(header: &[u8]) -> Result<Version, ParseError> {
	if header.len() < 1 {
		return Err(ParseError::InvalidHeaderLength);
	}
	match header[0] {
		1 => Ok(Version::Version1),
		2 => Ok(Version::Version2),
		_ => Err(ParseError::InvalidVersion)
	}
}

use std::fs::File;
use std::io;
use std::io::prelude::*;

struct Info {
	name: String,
	age: i32,
	rating: i32
}

fn write_info(info: &Info) -> io::Result<()> {
	let mut file = try!(File::create("my_best_friends.txt"));

	try!(writeln!(&mut file, "name: {}", info.name));
	try!(writeln!(&mut file, "age: {}", info.age));
	try!(writeln!(&mut file, "rating: {}", info.rating));

	return Ok(());
}