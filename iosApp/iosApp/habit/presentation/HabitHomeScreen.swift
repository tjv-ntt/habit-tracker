import Shared
import SwiftUI

struct HabitHomeScreen: View {
    @StateObject private var viewModel: HomeViewModel

    init() {
        let getAllHabitsUseCase = GetAllHabitsUseCase()
        let upsertHabitUseCase = UpsertHabitUseCase()
        _viewModel = StateObject(
            wrappedValue: HomeViewModel(
                getAllHabitsUseCase: getAllHabitsUseCase,
                upsertHabitUseCase: upsertHabitUseCase))
    }

    var body: some View {
        AppBar(viewModel: viewModel)
    }
}
