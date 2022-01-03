# MakeMyTrip

MakeMyTrip is an Indian online travel company founded in 2000. Headquartered in Gurugram, Haryana, the company provides online travel services including flight tickets, domestic and international holiday packages, hotel reservations, rail, and bus tickets. 

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

## Usage - Basepage

```Java
public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds).pollingEvery(pollingSeconds)
				.withMessage("Timeout occured!")
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
	}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
