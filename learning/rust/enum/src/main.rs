enum Message {
	Quit,
	ChangeColor(i32, i32, i32),
	Move {x: i32, y: i32},
	Write(String)
}

fn foo(x: String) -> Message {
	Message::Write(x)
}

fn quit() {

}

fn change_color(r: i32, g: i32, b: i32) {

}

fn move_cursor(x: i32, y: i32) {

}

fn process_message(msg: Message) {
	match msg {
	    Message::Quit => quit(),
	    Message::ChangeColor(r, g, b) => change_color(r, g, b),
	    Message::Move{x: x, y: y} => move_cursor(x, y),
	    Message::Write(s) => println!("{}", s)
	}
}
fn main() {
	let x: Message = Message::Move{x: 3, y: 4};

	enum BoardGameTurn {
		Move { squares: i32},
		Pass
	}

	let y: BoardGameTurn = BoardGameTurn::Move{ squares: 1};

	let m = Message::Write("Hello world!".to_string());
	process_message(m);
	let n = foo("Hello world".to_string());

	let v = vec!["Hello".to_string(), "world".to_string()];
	let v1: Vec<Message> = v.into_iter().map(Message::Write).collect();

	single_match();
	multiple_pattern_match();
	range_match();
	match_bind();
	ignore_bind();
	match_guard();
}

fn single_match() {
	let x = 1;
	match x {
		1 => println!("one"),
		2 => println!("two"),
		3 => println!("three"),
		_ => println!("anything")
	}
}

fn multiple_pattern_match() {
	let x = 1;
	match x {
	    1 | 2 => println!("one or two"),
	    3 => println!("three"),
	    _ => println!("anything")
	}
}

fn range_match() {
	let x = 1;
	match x {
	    1...5 => println!("one through five"),
	    _ => println!("anything"),
	}

	let y = '\0';
	match y {
	    'a'...'j' => println!("early letter"),
	    'k'...'z' => println!("late letter"),
	    _ => println!("something else")
	}
}

fn match_bind()
{
	let x = 1;
	match x {
	    e@1...5 => println!("got a range element{}", e),
	    _ => println!("anything"),
	}
}

fn ignore_bind() {
	enum OptionalTuple {
		Value(i32, i32, i32),
		Missing
	}

	let x = OptionalTuple::Value(5, -2, 3);
	match x {
	    OptionalTuple::Value(..) => println!("Got a tuple"),
	    OptionalTuple::Missing => println!("No such luck"),
	}
}

fn match_guard() {
	let x = 4;
	let y = false;

	match x {
	    4 | 5 if y => println!("yes"),
	    _ => println!("no"),
	}
}