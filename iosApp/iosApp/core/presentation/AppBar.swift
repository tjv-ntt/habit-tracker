import SwiftUI

struct AppBar: View {
    @StateObject var viewModel: HomeViewModel

    var body: some View {
        NavigationView {
            HabitCardList(viewModel: viewModel)
                .toolbar {
                    ToolbarItem(placement: .principal) {
                        Text("Habit Tracker")
                            .font(.title)
                    }
                }
        }
    }
}
