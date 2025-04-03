import Shared
import SwiftUI

struct HabitHomeScreen: View {
    @StateObject private var viewModel: HomeViewModel

    init() {
        let getAllHabitsUseCase = GetAllHabitsUseCase()
        let upsertHabitUseCase = UpsertHabitUseCase()
        let deleteHabitUseCase = DeleteHabitUseCase()
        _viewModel = StateObject(
            wrappedValue: HomeViewModel(
                getAllHabitsUseCase: getAllHabitsUseCase,
                upsertHabitUseCase: upsertHabitUseCase,
                deleteHabitUseCase: deleteHabitUseCase))
    }

    var body: some View {
        AppBar(viewModel: viewModel)
    }
}
