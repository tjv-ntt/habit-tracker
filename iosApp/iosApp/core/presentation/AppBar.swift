import SwiftUI

struct AppBar: View {
    var body: some View {
        NavigationView {
            HabitCardList()
                .toolbar {
                    ToolbarItem(placement: .principal) {
                        Text("Habit Tracker")
                            .font(.title)
                    }
                }
        }
    }
}
