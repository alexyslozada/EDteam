const Factorial = n => {
	if (n == 1 || n == 0) {
		return 1
	}

	return Factorial(n-1) * n
}

module.exports = Factorial
