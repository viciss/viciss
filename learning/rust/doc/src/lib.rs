/// Constructs a new `Rc<T>`
///
/// # Examples
///
/// ```
/// use std::rc::Rc;
///
/// let five = Rc::new(5);
/// ```
///
/// ```
/// Simple `&str` patterns:
///
/// ```
/// let v: Vec<&str> = "Mary had a little lamb".split(' ').collect();
/// assert_eq!(v, vec!["Mary", "had", "a", "little", "lamb"]);
/// ```
///
/// More complex patterns with a lambda:
///
/// ```
/// let v: Vec<&str> = "abc1def2ghi".split(|c: char| c.is_numeric()).collect();
/// assert_eq!(v, vec!["abc", "def", "ghi"]);
/// ```
///
/// ```c
/// printf("Hello world\n");
/// ```
/*
use std::rc::Rc;
pub fn new(value: T) ->Rc<T>
{

}
*/
/// The `Option` type. See [the module level documentation](../) for more.
enum Option<T> {
	/// No value
	None,
	/// Some value `T`
	Some(T)
}

/*
Following code could not be compiled because of the doc error
/// The `Option1` type. See [the module level documentation](../) for more.
enum Option1<T> {
	None, /// No value
	Some(T) /// Some value `T`
}
*/

/// Panic with a given message unless an expression evaluates to true.
///
/// # Example
///
/// ```
/// # #[macro_use] extern crate foo;
/// # fn main() {
/// panic_unless!(1+1==2,"Math is broken.");
/// # }
/// ```

/// ```should_panic
/// # #[macro_use] extern crate foo;
/// # fn main() {
/// panic_unless!(true==false, "I'm broken.");
/// # }
/// ```
#[macro_export]
macro_rules! panic_unless {
    ($condition:exp, $($rest:expr),+) => ({if ! $condition { panic!($($rest),+);}});
}