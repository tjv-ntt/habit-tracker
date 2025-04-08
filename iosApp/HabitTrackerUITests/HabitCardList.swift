import XCTest

final class HabitCardList: XCTestCase {
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

    func testHabitCardList() throws {
        let listView = getAppView(identifier: "HabitCardList")
        XCTAssertTrue(listView.exists)
    }

        //TODO: Fix this test
//    func testHabitCardListCount() throws {
//        let listView = getAppView(identifier: "HabitCardList")
//        let allHabits = Array(viewModel.getAllHabits()).count
//
//        XCTAssertTrue(
//            listView.descendants(matching: .staticText).count == allHabits)
//    }
}

