import unittest
from reverseLink import reverseLink

class TestReverseLink(unittest.TestCase):  
  
    def setUp(self):  
        pass  
  
    def test_reverseLink(self):  
        self.assertEqual(reverseLink(), 1) 
  
if __name__ == '__main__':  
    unittest.main()  