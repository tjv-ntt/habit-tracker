import SwiftUI

struct AppBar: View {
    var body: some View {
        NavigationView {
            HabitCard()
                .toolbar {
                    ToolbarItem(placement: .principal) {
                        Text("Habit Tracker")
                            .font(.title)
                    }
                }
        }
    }
}
