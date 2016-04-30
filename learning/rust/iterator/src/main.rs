fn range_test() {
	let mut range = 0..10;

	loop {
		match range.next() {
			Some(x) => {
				println!("{}", x);
			},
			None => { break; }
		}
	}
}

fn interator_test() {
	let nums = vec![1,2,3];
	for num in &nums {
		println!("{}", num);
	}

// same with previous code,
// right here, we use *num explictly indicate num is 
// in fact a reference
	for num in &nums {
		println!("{}", *num);
	}

// in following code, we don't use a reference
// so in for loop, num is a copy of nums[i]
	for num in nums {
		println!("{}", num);
	}

	let nums_1 = (1..100).collect::<Vec<i32>>();
	for num in &nums_1 {
		println!("{}", num);
	}

	let nums_2 =[1,2,3];
	for num in nums_2.iter() {
		println!("{}", num);
	}
}

fn consumer_test() {
	let greater_than_forty_two = (0..100)
		.find(|x| *x > 42);

	match greater_than_forty_two {
	    Some(_) => println!("We got some numbers!"),
	    None => println!("No numbers found :(")
	}
}

fn fold_test() {
	let sum = (1..4).fold(0, |sum, x| sum+x);
	println!("sum is {}", sum);
}

fn adaptive_iter_test() {
	// will never print anything
	// cause range is lasy, and map is another iterator
	// so, only when this map is consumed, then the range is 
	// expanded
	(1..100).map(|x| println!("{}", x));

	for i in (1..).take(5) {
		println!("{}", i);
	}

	for i in (1..100).filter(|&x| x % 2 == 0 ) {
		println!("{}", i);
	}

	for i in (1..1000)
		.filter(|&x| x % 2 == 0 )
		.filter(|&x| x % 3 == 0 )
		.take(5)
		.collect::<Vec<i32>>() {
		println!("{}", i);
	}
}

fn main() {
	range_test();
	interator_test();
	consumer_test();
	fold_test();
	adaptive_iter_test();
}
