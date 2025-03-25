import SwiftUI
import Shared

struct HabitHomeScreen: View {
    @StateObject private var viewModel: HomeViewModel

    init() {
        let habitRepository = HabitRepositoryHelper().getHabitRepository()
        let getAllHabitsUseCase = GetAllHabitsUseCase()
        _viewModel = StateObject(wrappedValue: HomeViewModel(getAllHabitsUseCase: getAllHabitsUseCase))
    }
    
    var body: some View {
        AppBar(viewModel: viewModel)
    }
}
