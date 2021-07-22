<template>
	<v-card flat class="py-12">
		<v-card-text>
			<v-row justify="center">
				<v-btn @click="$emit('prev')" color="primary">
					<v-icon>mdi-arrow-left-thick</v-icon>
				</v-btn>
				<v-spacer></v-spacer>
				<!-- <v-btn @click="$emit('fetch', 30)">
                            최근30일전
                        </v-btn> -->
				<v-btn @click="$emit('next')" color="primary">
					<v-icon>mdi-arrow-right-thick</v-icon>
				</v-btn>
			</v-row>
		</v-card-text>
	</v-card>
</template>
<script>
export default {
	data() {
		return {
			toggle_exclusive: undefined,
		};
	},
};
</script>
