macro_rules! vec {
    ( $( $x:expr ),*) => {
    	{
    		let mut temp_vec = Vec::new();
    		$(
    			temp_vec.push($x);
    		)*
    		temp_vec
    	}
    };
}

macro_rules! foo {
    (x => $e:expr) => (println!("mode X: {}", $e));
    (y => $e:expr) => (println!("mode Y: {}", $e));
}

fn main() {
	foo!(y => 3);
}
