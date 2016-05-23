fn main() {
	let a = 5;

	let _y = double(a);
    println!("{}", a);

    let b = true;
    // _y = change_truth(b) will fail
    // _y = double(10) will fail either
    // but let _y = change_truth(b) will success
    let _y = change_truth(b);
    println!("{}", b);

    let v1 = vec![1,2,3];
    let v2 = vec![1,2,3];

    let (v1, v2, answer) = foo(v1, v2);

    let answer = foo_ref(&v1, &v2);
}

fn double(x: i32) -> i32 {
	x * 2
}

fn change_truth(x: bool) -> bool {
	!x
}

fn foo(v1: Vec<i32>, v2: Vec<i32>) -> (Vec<i32>,Vec<i32>,i32) {
	(v1, v2, 42)
}

fn foo_ref(v1: &Vec<i32>, v2: &Vec<i32>) -> i32 {
	42
}