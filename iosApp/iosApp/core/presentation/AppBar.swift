import SwiftUI

struct AppBar: View {
    var body: some View {
        NavigationView {
            Text("List Tiles Placeholder")
                .toolbar {
                    ToolbarItem(placement: .principal) {
                        Text("Habit Tracker")
                            .font(.title)
                    }
                }
        }
    }
}
