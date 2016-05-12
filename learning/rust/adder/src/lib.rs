//! The `adder` crate provides functions that add numbers to other numbers
//!
//! # Examples
//!
//! ```  
//! assert_eq!(4, adder::add_two(2));
//! ```

/// This function adds two to its argument.
///
/// #Examples
///
/// ``` 
/// use adder::add_two;
///
/// assert_eq!(4, add_two(2));
/// ```

pub fn add_two(a: i32) -> i32 {
	a + 2
}

#[cfg(test)]
mod test {
	use super::*;

    #[test]
//    #[should_panic(expected="assertion failed")]
    fn it_works() {
//    	assert!(false);
//		assert_eq!("Hello", "world");
		assert_eq!(4, add_two(2));
    }
}
