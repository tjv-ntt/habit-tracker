import XCTest

final class HabitHomeScreen: XCTestCase {
    let app = XCUIApplication()

    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.

        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
        app.launch()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testAppBar() throws {
        // UI tests must launch the application that they test.
        let expectedText = "Habit Tracker"
        
        // Or to verify text content:
        XCTAssertEqual(app.staticTexts["Habit Tracker"].firstMatch.label, expectedText)

        // Use XCTAssert and related functions to verify your tests produce the correct results.
    }
}
