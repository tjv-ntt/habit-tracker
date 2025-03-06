import XCTest

final class HabitCard: XCTestCase {
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
    
    func testHabitCardToggle() throws {
        // Find the toggle by its accessibility identifier
        let toggle = app.switches["HabitCardToggle"]
        // Assert that the toggle is initially off (or on, depending on your initial state)
        XCTAssertFalse(toggle.value as? String == "1") // or XCTAssertTrue if initially on
        // Tap the toggle to change its state
        toggle.tap()
        // Assert that the toggle is now on (or off, depending on your initial state)
        XCTAssertTrue(toggle.value as? String == "1") // or XCTAssertFalse if initially on
    }
    
    func testHabitCardText() throws {
        let textView = getAppView(identifier: "HabitCardText")
        XCTAssertTrue(textView.exists)
    }
}
